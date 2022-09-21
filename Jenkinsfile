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
                slackSend baseUrl: 'https://nutanix.slack.com/services/hooks/jenkins-ci/', channel: '#database-migration-automation', color: '#BADA55', message: 'DB_Deployment', teamDomain: '#database-migration-automation', token: 'PmzyVip4nrIAylqjpAV87y74', tokenCredentialId: '99728ace-203a-4546-b607-da3f7309af9b'
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
