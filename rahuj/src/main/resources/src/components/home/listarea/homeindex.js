import ListFinans from "./listfinans"
const HomeIndex = () => {
    return (
        <div className="flex flex-col bg-[#7b8a8a] p-5 m-5 rounded-2xl gap-5">
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
export default HomeIndex;
