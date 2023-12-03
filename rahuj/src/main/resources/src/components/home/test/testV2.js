import axios from "axios"



    async function TestV2() {
        let todos = await axios.get(
            "http://localhost:8080/auth/test"
        );
        console.log(todos.data)
    } 




  
export default TestV2;
