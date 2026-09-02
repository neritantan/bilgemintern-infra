def call() {
    sh 'gitleaks git --redact .'
}
