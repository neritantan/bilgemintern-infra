pipeline {
    agent any
    triggers {
        // When code gets pushed to the repository.
    }
    stages {
        stage('Build') {
            steps {
                // Download the source code from the repository and build the application.
                // docker build
                // docker run 
            }
        }
        stage('Test') {
            steps {
                // Run required tests to verify the application is working.
            }
        }   

        stage('Deploy') {
            steps {
                // Upload the application to the GHCR using commit hash as the tag.
                // SSH to the dev server and deploy the application.
            }
        }
    }
}