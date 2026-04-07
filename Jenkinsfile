pipeline {
    agent any

    environment {
        APP_NAME = 'fintanspetitions'
    }

    stages {
        stage('Get Code') {
            steps { 
                echo 'pulled code from GitHub'
             }
        }
        stage('Build') {
            steps { 
                echo "Cleaning and compiling ${APP_NAME} project"
                sh 'chmod +x mvnw'
                sh './mvnw clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'Running unit tests'
                sh './mvn test'
            }
        }
        stage('Package') {
            steps {
                echo 'Packaging the project as war'
                sh './mvn package'
            }
        }
        stage('Approve Deploy') {
            steps {
                input message: 'Do you want to deploy?', ok: 'Deploy'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Starting to deploy the app'
                sh "sudo cp target/${APP_NAME}.war /opt/tomcat/webapps/"
                echo 'Deployment finished'
            }
        }
    }
    post {
        success {
            echo 'Pipeline a success'
        }
        failure {
            echo 'Pipeline failed'
        }
    }
}