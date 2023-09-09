import ButtonHome from "../listarea/buttonHome";
import ListFinans from "../listarea/listfinans";

const AddNew = () => {
    return (
        <div className="flex flex-col bg-[#7b8a8a] p-5 m-5 rounded-2xl gap-5">
            <div className="text-center text-4xl text-light-green">Всі доходи</div>

            <ul className="bg-[#52aea3] flex place-content-around p-3 rounded-xl items-stretch gap-4 items-center">
                <input className="lastcghange__item flex-1 self-center" type="date" id="date" name="date"/>
                <select name="category" className="lastcghange__item flex-1 self-center">
                    <option value="1">ЗП Дружина</option>
                    <option value="2">ЗП Чоловік</option>
                    <option value="3">Аванс Дружина</option>
                    <option value="4">Аванс Чоловік</option>
                    <option value="5">Подарунок</option>
                </select>
                <input className="lastcghange__item flex-1 self-center" type="number"></input>
                <textarea className="lastcghange__item flex-1 self-center"></textarea>
                <ButtonHome name="додати"></ButtonHome>
                
            </ul>

            <ListFinans></ListFinans>
            {
                //<ul className="bg-[#52aea3] flex place-content-around p-3 rounded-xl">
                // <li className="lastcghange__item">дія</li>
                //<li className="lastcghange__item">категорія</li>
                //<li className="lastcghange__item">сума</li>
                // <li className="lastcghange__item">дата</li>
                //</ul>
            }

        </div>

    )
}

export default AddNew;