node('maven') {
  stage('Build') {
    git url: "https://github.com/DayongLu/user-mgmt-service.git"
    sh "mvn package"
    stash name:"jar", includes:"target/user-mgmt-service-0.0.1-SNAPSHOT.jar"
  }

  stage('Build Image') {
    unstash name:"jar"
    sh "oc start-build user-mgmt-service --from-dir=./target/ --follow=true"
  }
  stage('Deploy') {
    openshiftDeploy depCfg: 'user-mgmt-service'
    openshiftVerifyDeployment depCfg: 'user-mgmt-service', replicaCount: 1, verifyReplicaCount: true
  }

}