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
                sh 'sleep 3'
            }
        }
        stage ('Setting up Environment') {
            steps {
                sh 'sleep 3'
            }
        }
        stage ('Database Snapshot') {
            steps {
                sh 'sleep 3'
            }
        }
        stage ('Compile & build') {
            steps {
                sh 'sleep 5'
                sh "echo Hello"
            }
        }
        stage ('Database Migration') {
            steps {
                script {
                    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                        migrationSucceeded = "false"
                        sh 'exit 1'
                    }
                }
//                     sh 'exit 1'
            }
        }
        stage ('Restore Database') {
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
            when {
                expression {
                    deploymentSucceeded = 'false'
                }
            }
            steps {
                script {
                    echo "restoring from version"
                    sh 'sleep 5'
                }
            }
        }
    }
}
