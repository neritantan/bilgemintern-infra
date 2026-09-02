def call() {
    docker.image('zricethezav/gitleaks:v8.30.1').inside('--entrypoint=') {
        sh 'gitleaks git --redact -v .'
    }
}
