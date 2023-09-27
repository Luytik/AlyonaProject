import AddFilsAll from "./addFilsAll";
import GetAllListCome from "./getAllListCome";

const AddNewInCome = () => {
    return (

        <div className="bg-[#7b8a8a] flex flex-col place-content-around p-3 m-5 rounded-xl items-stretch gap-4 items-center">
            <div className="text-center text-4xl text-light-green">Додати дохід</div>
            {/* <AddFils /> */}
            <AddFilsAll link = {"http://localhost:8080/api/revenue/"} category = {"revenueCategoryDTO"}/>
            <div className="text-center text-4xl text-light-green">Список доходів:</div>

            <GetAllListCome></GetAllListCome>
            
        </div>

    )
}

export default AddNewInCome;