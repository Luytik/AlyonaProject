import { Link } from "react-router-dom";

const ButtonHome = (homeBtn) => {
    return (
        <Link to={homeBtn.link}>
            <input className="h-11 px-4 bg-[#295545] text-[#fff] rounded-2xl" type="button" value={homeBtn.name}/>
        </Link>
    )

}

export default ButtonHome;