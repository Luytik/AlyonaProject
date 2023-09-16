import { useState, useEffect } from "react";
import Servises from "../../servises/servises";
import MyComponent from "../statistics/testpost";

function GetSelectCategory() {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [items, setItems] = useState([]);

    useEffect(() => {
        new Servises().getCategoryCost()
            .then(
                (result) => {
                    setIsLoaded(true);
                    setItems(result);
                },

                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            )
    }, [])




    
    if (error) {
        return <div>Error: {error.message}</div>;
    } else if (!isLoaded) {
        return <div>Загрузка...</div>;
    } else {
        return (
            <>
                <select name="category" className="lastcghange__item flex-1 self-center">
                    <option value="обери категоррію">Обери категорію</option>
                    {items.map((item, index) => (
                        <option value={item.expenditureCategoryDTO} key={index + "b"}>{item.expenditureCategoryDTO}</option>
                    ))
                    }
                    <option value="додати нову категорію" onClick={() => document.getElementById('my_modal_1').showModal()}>Додати нову категорію</option>

                </select>

            </>
        );
    }
}

export default GetSelectCategory;