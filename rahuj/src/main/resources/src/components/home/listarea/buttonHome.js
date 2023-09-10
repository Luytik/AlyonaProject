import { Link } from "react-router-dom";

const ButtonHome = (homeBtn) => {
    return (
        <Link to={homeBtn.link}>
            <input className="h-11 w-28 bg-[#295545] text-[#fff] rounded-2xl" type="button" value={homeBtn.name} key={homeBtn.key}/>
        </Link>
    )

}

export default ButtonHome;