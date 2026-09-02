def call() {
    sh 'docker run --rm -v $WORKSPACE:/scan -v /var/jenkins_home/trivy-cache:/root/.cache/trivy aquasec/trivy:0.74.0 fs --severity HIGH,CRITICAL --ignore-unfixed --exit-code 1 /scan'
}
