pipeline {
    agent any
    stages {
        stage ('Compile Stage') {
            steps {
                withMaven(maven : 'maven_3.8.4') {
                    sh 'maven clean compile'
                }
            }
        }
        stage ('Testing Stage') {
            steps {
                withMaven(maven : 'maven_3.8.4') {
                    sh 'maven test'
                }
            }
        }
        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'maven_3.8.4') {
                    sh 'maven deploy'
                }
            }
        }
    }

}
