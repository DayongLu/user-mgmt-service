node('maven') {


  stage('Build Source To Image') {
    sh "oc start-build user-mgmt-service"
  }
  stage('Deploy') {
    openshiftDeploy depCfg: 'user-mgmt-service'
    openshiftVerifyDeployment depCfg: 'user-mgmt-service', replicaCount: 1, verifyReplicaCount: true
  }

}