Vagrant.configure("2") do |config|

  config.vm.define "jenkins" do |jenkins|
    jenkins.vm.box = "debian/bullseye64"
    jenkins.vm.hostname = "jenkins"
    jenkins.vm.network "private_network", ip: "192.168.33.12"
    jenkins.vm.synced_folder "jenkins2", "/srv/share"
  end

  config.vm.provision "ansible" do |ansible|
    ansible.playbook = "provisioning/playbook.yml"
    ansible.compatibility_mode = "2.0"
  end

  #config.vm.synced_folder "../data", "/vagrant_data", type: "nfs"

  config.vm.provider "virtualbox" do |vb|
    vb.memory = "1024"
    vb.cpus = "2"
  end
end
