node('maven') {
  stage('Build') {
    git url: "https://github.com/DayongLu/user-mgmt-service.git"
    sh "mvn package"
    stash name:"jar", includes:"target/user-mgmt-service.jar"
  }

  stage('Build Image') {
    unstash name:"jar"
    sh "oc start-build user-mgmt-service --from-file=target/user-mgmt-service.jar --follow"
  }
  stage('Deploy') {
    openshiftDeploy depCfg: 'user-mgmt-service'
    openshiftVerifyDeployment depCfg: 'user-mgmt-service', replicaCount: 1, verifyReplicaCount: true
  }

}