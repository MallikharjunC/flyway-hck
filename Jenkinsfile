stageResultMap = [:]

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
                script {
                    // Catch exceptions, set the stage result as unstable,
                    // build result as failure, and the variable didB1Succeed to false
                    try {
                        sh "exit 1"
                        stageResultMap.didB1Succeed = true
                    }
                    catch (Exception e) {
                        unstable("${STAGE_NAME} failed!")
                        currentBuild.result = 'FAILURE'
                        stageResultMap.didB1Succeed = false
                    }
                }
            }
        }
        stage ('Compile & build') {
            when {
                expression {
                    return stageResultMap.find{ it.key == "didB1Succeed" }?.value
                }
            }
            steps {
                sh 'sleep 5'
                catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                sh "echo Hello"
                }
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
