#!groovy
import jenkins.model.*
import jenkins.security.s2m.*
import hudson.security.*

def instance = Jenkins.getInstance()

jlc = JenkinsLocationConfiguration.get()
jlc.setUrl("http://192.168.33.14:8080/")
println(jlc.getUrl())

jlc.save()


println "--> enabling slave master access control"
instance.injector.getInstance(AdminWhitelistRule).setMasterKillSwitch(false);

println "--> disabling allow anonymous read access"
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
instance.setAuthorizationStrategy(strategy)

instance.save()
