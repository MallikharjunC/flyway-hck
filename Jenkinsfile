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
                migrationSucceeded = "false"
            }
        }
        stage ('Restore Databse') {
            steps {
                if(migrationSucceeded == "false") {
                    sh 'exit 1'
                } else {
                    echo "restoring from backup"
                    sh 'sleep 5'
                }
            }
        }
        stage ('Deployment') {
            steps {
                script {
                    if(migrationSucceeded == "true") {
                        echo "deployment successful"
                        sh 'sleep 5'
                        deploymentSucceeded = "true"
                    } else {
                        echo "skipping deployment"
                                    sh 'exit 1'
                    }
                }

            }
        }
        stage ('Rollback Database version') {
            steps {
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
