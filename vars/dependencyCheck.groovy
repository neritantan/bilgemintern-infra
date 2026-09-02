def call() {
    withCredentials([string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')]) {
        sh 'docker run --rm -u 1000:1000 -v $WORKSPACE:/src -v /var/jenkins_home/dc-data:/usr/share/dependency-check/data owasp/dependency-check:13.0.0 --scan /src --project bilgemintern --format HTML --out /src/dc-report --enableExperimental --nvdApiKey $NVD_API_KEY --failOnCVSS 9'
    }
    archiveArtifacts artifacts: 'dc-report/**', allowEmptyArchive: true
}
