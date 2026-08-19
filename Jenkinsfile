pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                sh 'echo "Running tests..."'
                echo "test took ${currentBuild.durationString} to complete"
            }
        }
    }
}