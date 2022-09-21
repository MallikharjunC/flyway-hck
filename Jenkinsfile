pipeline {
    agent { label 'master' }
    tools {
            maven 'Maven 3.5.0'
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
            }
        }
        stage ('Migration Stage') {
            steps {
                sh 'mvn clean compile test -DconfigFileName=/var/lib/jenkins/workspace/flyway_conf'
            }
        }
        stage ('Deployment') {
            steps {
                sh 'sleep 5'
            }
        }
        stage ('Rollback Database Changes') {
            steps {
                sh 'sleep 5'
            }
        }
    }

}
