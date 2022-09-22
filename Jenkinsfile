pipeline {
    agent { label 'master' }
    tools {
            maven 'Maven 3.5.0'
    }
    environment  {
       def migrationSucceeded = "false"
       def deploymentSucceeded = "false"
    }
    stages {
        stage ('cloning repo') {
            steps {
                sh 'sleep 5'
            }
        }
        stage ('Setting up Environment') {
            steps {
                sh 'sleep 5'
            }
        }
        stage ('Compile & build') {
            steps {
                sh 'sleep 5'
                sh "echo Hello"
            }
        }
        stage ('Migration Stage') {
            steps {
                script {
                    migrationSucceeded = "false"
                }
            }
        }
        stage ('Restore Databse') {
            steps {
                script {
                    if(migrationSucceeded == "true") {
                        sh 'exit 1'
                    } else {
                        echo "restoring from backup"
                        sh 'sleep 5'
                    }
                }
            }
        }
        stage ('Deployment') {
            when {
                expression {
                    migrationSucceeded = 'true'
                }
            }
            steps {
                script {
                    echo "deployment successful"
                    sh 'sleep 5'
                }
            }
        }
        stage ('Rollback Database version') {
            steps {
                script {
                    if(deploymentSucceeded == "true") {
                        echo "skipping successful"
                        sh 'exit 1'
                    } else {
                        echo "restoring from version"
                        sh 'sleep 5'
                    }
                }
            }
        }
    }
}
