def latestTag
pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven"
    }



    stages {
        stage('Check recent release') {
            steps {
                script{
                     latestTag = sh script: 'git describe --tags --abbrev=0', returnStdout: true
                                  echo "Latest tag: ${latestTag}"
                }


            }
        }
        stage('Build Maven') {
            when {
                buildingTag()
            }
            steps {
                sh 'echo it is tag'
                // Get some code from a GitHub repository
                checkout scmGit(branches: [[name: ${latestTag}]], extensions: [], userRemoteConfigs: [[credentialsId: 'github', url: 'https://github.com/CheonInJeong/simple-app.git']])
//                 sh "mvn -Dmaven.test.failure.ignore=true clean package"

            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    sh "echo build success"
                   // junit '**/target/surefire-reports/TEST-*.xml'
                    //archiveArtifacts 'target/*.jar'
//                     junit(
//                         allowEmptyResults:true,
//                         testResults: '*test-reports/.xml'
//                     )
                }
            }
        }
        stage("TEST") {
            steps {
                script {
                    sh 'echo test finished'
                }
            }
        }
//         stage("Build Docker Image") {
//             steps {
//                 script {
//                     sh 'docker build -t ijcheon/simple_app:0.1 .'
//                 }
//             }
//         }
//         stage("Push Docker file") {
//             steps {
//                 withCredentials([usernameColonPassword(credentialsId: 'dockerhub', variable: 'dockerhub-pwd')]) {
//                     sh 'docker login -u ijcheon -p ${dockerhub-pwd}'
//
//                     sh 'docker push ijcheon/simple_app:0.1'
//
//                 }
//
//             }
//         }
    }
}