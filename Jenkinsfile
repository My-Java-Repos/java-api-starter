#!/usr/bin/groovy
@Library('naftis')
@Library('link-pipeline-library')
 
def dbChangeLogFile = "src/db/db.changelog-master.xml"

def pipeline = new com.org.link.naftis.pipeline.BasePipeline().init([
  preDeploy: { boolean isPullRequest, String deployEnv ->
  linkCoreLiquibase(deployEnv, dbChangeLogFile)
  }
])