pipeline {
    agent any
    triggers {
        // When code gets pushed to the repository. (Gets triggered by the webhook via plugin).
    }
    stages {
        stage('Build') {
            steps {
                // Download the source code from the repository and build the application.
                sh 'git clone https://github.com/neritantan/bilgemintern-backend.git'
                // docker build
                sh 'docker build -t bilgemintern-backend:latest ./bilgemintern-backend'
                // docker run 
                sh 'docker run -d --name app -p 80:8000 bilgemintern-backend:latest'
            }
        }
        stage('Test') {
            steps {
                // Run required tests to verify the application is working.
                sh 'sleep 30' // Wait for the application to start
                sh 'curl -f localhost'
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
}