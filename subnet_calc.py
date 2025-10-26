import ipaddress

def subnet_calculator():
    while True:
        print("\n--- IP Subnetting Calculator ---")
        print("1. Calculate subnet details")
        print("2. Exit")
        choice = input("Enter your choice: ")

        if choice == '1':
            ip_input = input("Enter IP address with CIDR (e.g., 205.16.37.39/28): ")

            try:
                network = ipaddress.ip_network(ip_input, strict=False)

                print("\nResults:")
                print(f"Network ID       : {network.network_address}")
                print(f"Subnet Mask      : {network.netmask}")
                print(f"Broadcast Address: {network.broadcast_address}")

                all_hosts = list(network.hosts())
                print(f"First Usable     : {all_hosts[0] if all_hosts else 'N/A'}")
                print(f"Last Usable      : {all_hosts[-1] if all_hosts else 'N/A'}")
                print(f"Total Addresses  : {network.num_addresses}")
                print(f"Usable Hosts     : {len(all_hosts)}")

            except ValueError:
                print("Invalid IP address or CIDR notation. Try again.")

        elif choice == '2':
            print("Exiting program.")
            break
        else:
            print("Invalid choice. Try again.")

subnet_calculator()
