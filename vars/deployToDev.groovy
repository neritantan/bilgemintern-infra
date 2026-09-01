def call(Map cfg) {
    withCredentials([
        sshUserPrivateKey(credentialsId: 'server-ssh', keyFileVariable: 'SSH_KEY', usernameVariable: 'SSH_USER'),
        usernamePassword(credentialsId: 'ghcr-login', passwordVariable: 'GHCR_PAT', usernameVariable: 'GHCR_USER')
    ]) {

        def img = "ghcr.io/${env.GHCR_USER}/${cfg.image}:${cfg.tag}"

        sh """
        ssh -i \$SSH_KEY -o StrictHostKeyChecking=no \$SSH_USER@dev '
            docker stop ${cfg.name} || true
            docker rm ${cfg.name} || true
            docker pull ${img}
            docker run -d --name ${cfg.name} -p ${cfg.ports} ${img}
            docker image prune -a -f --filter "until=24h"
        '
        """
    }
}
