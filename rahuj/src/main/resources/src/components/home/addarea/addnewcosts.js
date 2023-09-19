import ButtonHome from "../listarea/buttonHome";
import ListFinans from "../listarea/listfinans";
import GetSelectCategory from "./getSelectCftegory";

const AddNewCosts = () => {
    return (
        <div className="flex flex-col bg-[#7b8a8a] p-5 m-5 rounded-2xl gap-5">
            <div className="text-center text-4xl text-light-green">Всі витрати</div>

            <ul className="bg-[#52aea3] flex place-content-around p-3 rounded-xl items-stretch gap-4 items-center">
                <input className="lastcghange__item flex-1 self-center" type="date" id="date" name="date" />
                <GetSelectCategory/>
                <input className="lastcghange__item flex-1 self-center" type="number"></input>
                <textarea className="lastcghange__item flex-1 self-center"></textarea>
                <ButtonHome name="зберегти" onClick={() => document.getElementById('my_modal_1').showModal()}></ButtonHome>

            </ul>

            <ListFinans></ListFinans>
            
        </div>

    )
}

export default AddNewCosts;