#!groovy
import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
def users = hudsonRealm.getAllUsers()

def adminUser = 'admin'
def adminPassword = adminUser

users_s = users.collect { it.toString() }

// Create the admin user account if it doesn't already exist.
if (adminUser in users_s) {
    println "--> Admin user already exists - updating password"

    def user = hudson.model.User.get(adminUser);
    def password = hudson.security.HudsonPrivateSecurityRealm.Details.fromPlainPassword(adminPassword)
    user.addProperty(password)
    user.save()
} else {
    println "--> creating local admin user"

    hudsonRealm.createAccount(adminUser, adminPassword)
    instance.setSecurityRealm(hudsonRealm)

    def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
    instance.setAuthorizationStrategy(strategy)
    instance.save()
}
