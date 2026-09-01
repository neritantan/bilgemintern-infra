def call() {
    withCredentials([sshUserPrivateKey(credentialsId: 'server-ssh', keyFileVariable: 'SSH_KEY', usernameVariable: 'SSH_USER')]) {
        sh '''
        ssh -i $SSH_KEY -o StrictHostKeyChecking=no $SSH_USER@dev '
            docker compose pull
            docker compose down
            docker compose up -d
            docker image prune -a -f --filter "until=24h"
        '
        '''
    }
}
