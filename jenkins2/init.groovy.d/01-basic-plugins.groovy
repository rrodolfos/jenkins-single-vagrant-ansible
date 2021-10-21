#!groovy
import jenkins.model.*

def plugins = [
  'configuration-as-code',
  'cloudbees-folder',
  'antisamy-markup-formatter',
  'build-timeout',
  'credentials-binding',
  'timestamper',
  'ws-cleanup',
  'ant',
  'gradle',
  'workflow-aggregator',
  'github-branch-source',
  'pipeline-github-lib',
  'pipeline-stage-view',
  'git',
  'subversion',
  'ssh-slaves',
  'matrix-auth',
  'pam-auth',
  'ldap',
  'email-ext',
  'mailer',
  'chucknorris'
]

Jenkins.instance.updateCenter.updateDefaultSite()

plugins.each {
  println "Installing plugin: $it"
  Jenkins.instance.updateCenter.getPlugin(it).deploy(true)
}

