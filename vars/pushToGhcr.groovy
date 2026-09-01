def call(Map cfg) {
    withCredentials([usernamePassword(credentialsId: 'ghcr-login', passwordVariable: 'GHCR_PAT', usernameVariable: 'GHCR_USER')]) {
        sh 'echo $GHCR_PAT | docker login ghcr.io -u $GHCR_USER --password-stdin'

        def img = "ghcr.io/${env.GHCR_USER}/${cfg.image}:${cfg.tag}"

        if (sh(script: "docker manifest inspect ${img} > /dev/null 2>&1", returnStatus: true) != 0) {
            sh "docker tag ${cfg.image}:latest ${img}"
            sh "docker push ${img}"
        }
        else {
            echo "Image ${img} already exists in GHCR. Skipping push."
        }
    }
}
