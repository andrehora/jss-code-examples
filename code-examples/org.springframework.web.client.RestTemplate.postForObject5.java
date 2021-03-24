private void createEmployee() {

        Employee newEmployee = new Employee("admin", "admin", "admin@gmail.com");

        RestTemplate restTemplate = new RestTemplate();
        Employee result = restTemplate.postForObject(CREATE_EMPLOYEE_ENDPOINT_URL, newEmployee, Employee.class);

        System.out.println(result);
    }