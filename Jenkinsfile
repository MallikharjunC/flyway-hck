pipeline {
    agent { label 'master' }
    tools {
            maven 'Maven 3.5.0'
    }
    environemnt  {
       migrationSucceeded = false
       deploymentSucceeded = false
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
//                 catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                sh "echo Hello"
            }
        }
        stage ('Migration Stage') {
            steps {
//                 sh 'mvn clean compile test -DconfigFileName=/var/lib/jenkins/workspace/flyway_conf'
                migrationSucceeded = false
            }
        }
        stage ('Restore Databse') {
            steps {
                if(migrationSucceeded) {
                    sh 'exit 1'
                } else {
                    echo "restoring from backup"
                    sh 'sleep 5'
                }
            }
        }
        stage ('Deployment') {
            steps {
                if(migrationSucceeded) {
                    echo "deployment successful"
                    sh 'sleep 5'
                } else {
                    echo "skipping deployment"
                    sh 'exit 1'
                }
            }
        }
        stage ('Rollback Database version') {
            steps {
                if(deploymentSucceeded) {
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
