import { useContext, useEffect, useState } from "react";
import { Login } from "../../../App";


// function TestV3() {
//     const [error, setError] = useState(null);
//     const [isLoaded, setIsLoaded] = useState(false);
//     const [items, setItems] = useState("");

//     useEffect(() => {
//         fetch("http://localhost:8080/auth/test", {
//             method: 'GET',
//             headers: {
//               "Content-Type": "application/json",
//               "username": "vadik"},
//               "password" : "pass"})
//         .then(res => res.json())
//         .then(
//             (result) => {
//                 setIsLoaded(true);
//                 setItems(result);
//             },
//             (error) => {
//                 setIsLoaded(true);
//                 setError(error);
//             }
//         )
//     }, [])
//     console.log(items)


    
//     if (error) {
//         return<div>error</div>
//     } else if (!isLoaded) {
//         return<div>loaded</div>
//     } else {
//         return (
//         <div className="bg-[#9db0b0] p-5 my-5 rounded-2xl gap-5 w-1/2 mx-auto">
//            <p>sdjsdbskjdcsjdcnjksd</p>
//             <p>{items}</p>
        

//         </div>
//     )
//     }

    
// }
class TestV {
    async getListCome(username, password) {
    try {
      const data = await fetch("http://localhost:8080/auth/test", {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Basic ${btoa(`${'vadik'}:${'pass'}`)}`,
        },
      });
  
      if (!data.ok) {
        // Обробка помилок
        throw new Error(`HTTP error! Status: ${data.status}`);
      }
  
      return await data.json();
    } catch (error) {
      console.error('Помилка при отриманні даних:', error);
      throw error;
    }
  }
}

export default TestV;