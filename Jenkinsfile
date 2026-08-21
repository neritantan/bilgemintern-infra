pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Clean up the workspace before starting the build.
                cleanWs()
                // Download the source code from the repository and build the application.
                sh 'git clone https://github.com/neritantan/bilgemintern-backend.git'
                // docker build
                sh 'docker build -t bilgemintern-backend:latest ./bilgemintern-backend'
                // docker run 
                sh 'docker run -d --name app -p 8000:8000 bilgemintern-backend:latest'
            }
        }
        stage('Test') {
            steps {
                // Run required tests to verify the application is working.
                sh 'sleep 30' // Wait for the application to start
                withCredentials([string(credentialsId: 'host-ip', variable: 'HOST_IP')]) {
                    sh 'curl -f $HOST_IP:8000'
                }
            }  
        }

        stage('Push') {
            steps {
                // Upload the application to the GHCR using commit hash as the tag.



                //testing
                sh 'echo "Pushing to GHCR..."'
            }
        }   

        stage('Deploy') {
            steps {
                // SSH to the dev server and deploy the application.
                sh 'echo "Deploying to dev server..."'
            }
        }
    }
    post {
        always {
            sh 'docker stop app || true'
            sh 'docker rm app || true'
            sh 'docker rmi bilgemintern-backend:latest || true'
        }
    }
}