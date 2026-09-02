def call(String image) {
    sh "docker run --rm -v /var/run/docker.sock:/var/run/docker.sock -v /var/jenkins_home/trivy-cache:/root/.cache/trivy aquasec/trivy:0.74.0 image --severity HIGH,CRITICAL --ignore-unfixed --exit-code 1 ${image}"
}
