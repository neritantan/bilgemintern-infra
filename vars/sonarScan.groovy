def call(String projectKey) {
    withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
        sh "docker run --rm -u 1000:1000 --network sonar-net -v \$WORKSPACE:/usr/src sonarsource/sonar-scanner-cli:12.1 -Dsonar.projectKey=${projectKey} -Dsonar.host.url=http://sonarqube:9000 -Dsonar.token=\$SONAR_TOKEN"
    }
}
