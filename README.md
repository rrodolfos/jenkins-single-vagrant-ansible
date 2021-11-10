# Configuring jenkins with ansible and Jenkins configuration as code on vagrant
This repository contains vagrant and ansible configuration to deploy and provision a single jenkins server with jenkins configuration as code (a.k.a. JCasC):

  - [Jenkins](https://www.jenkins.io/)
  - [Jenkins Configuration as Code (a.k.a. JCasC) Plugin](https://www.jenkins.io/projects/jcasc/)

# DISCLAIMER
> This implementation is intended for testing / PoC / playing purposes only, this solution is not scalable or secure enough for live / production environments. Use it at your own risk. Have fun!.

# Requirements
The below requirements are needed to deploy and provision Jenkins VM.

  - [VirtualBox](https://www.virtualbox.org/)
  - [Vagrant](https://www.vagrantup.com/)
  - [Ansible](https://www.ansible.com/)

# what did I use for this?
  - MacBook Pro 2015 CPU Core i5 8GB RAM
  - OS GNU Linux/Debian 12 Bookworm 64bits
  - VirtualBox 6.1.16
  - Vagrant 2.2.14
    - Vagrant box debian/bullseye64
  - Ansible 2.10.8

# Included content
  - Vagrantfile
  - ansible.cfg
  - Playbook.yml
  - Roles
    - common
    - jenkins

# Vagrantfile
VM machine definition as follow:
  - jenkins
    - 2 vcpu
    - 1024 RAM
    - 192.168.33.12 VM ip address 

# How to build it

### Jenkins
This VM deploy a single Jenkins server as follow (by ansible):
  - Install Jenkins dependencies
  - Copy Jenkins default configuration
  - Create Jenkins home
  - Create init.groove.d directory with the configuration file ([Groovy Hook Scripts](https://www.jenkins.io/doc/book/managing/groovy-hook-scripts/)) for modules instalation (JCasC among them) into jenkins home
  - copy jenkins.yml for JCasC and "automagically" configuration into jenkins home
  - Install Jenkins
  - Remove jenkins.yml
  - Have fun!

##### Clone this repository:
```
  $ git clone https://github.com/rrodolfos/jenkins-single-vagrant-ansible.git
```

##### Chande to the repository directory:
```
  $ cd jenkins-single-vagrant-ansible
```

##### Create vagrant VM and deploy jenkins:
To start up the VM
```
  $ vagrant up
```
> Coffee time!. On a MacBook Pro 2015 and 100Mbps bandwidth it took ~6 minutes. Vagrant box downloading (base linux distro) not included.

##### Check the VM:
To connect to the VM (ssh)
```
  $ vagrant ssh
```

##### Connect to jenkins:
To connect via web browser
```
  http://192.168.33.12:8080/
```
  `Username:` admin
  `Password:` admin

##### Destroy vagrant VM:
To destroy the VM
```
  $ vagrant destroy
```

# Author

> Rodolfo Sauce-Guinand - rrodolfos gmail com
