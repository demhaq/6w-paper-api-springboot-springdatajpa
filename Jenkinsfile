pipeline {
    agent any
    
	
    environment{
        JENKINS_NODE_COOKIE = 'dontkillmeplease'
        PORT=8081
    }
    stages {
        stage('Preparation') { // for display purposes
            steps {
              // clean out the workspace
              cleanWs()
            }
        }        
        stage('Download') {
           steps {
              // Download code from a GitHub repository
              // branch: the branch that you want to build
              // credentialsId: the ID of the credentials for your GitLab repo that is being managed by Jenkins
              // url: url to your repo
              git branch: 'master', credentialsId: '6b1b9ef6-b68d-4b20-b61d-beaa2ec83571', url: 'https://github.com/demhaq/6w-paper-api-springboot-springdatajpa.git'
           }
        }
        stage ('Build') {

            steps {
                sh "mvn clean"
                
            }
        } 
        stage('Compile'){
            steps{
                sh "mvn package"
            }
        }
       
        stage('Destroy Old Server') {
            steps {
                script {
                    try {
                        // kill any running instances of the app if applicable
                        sh 'kill $(lsof -t -i:$PORT)'
                    } catch (all) {
                        // if it fails that should mean a server wasn't already running
                        echo 'No server was already running'
                    }
                }
            }
        }
        stage('Run Spring App'){
            steps{
                sh 'nohup mvn spring-boot:run &'
            }
        }
        
        
    }
}