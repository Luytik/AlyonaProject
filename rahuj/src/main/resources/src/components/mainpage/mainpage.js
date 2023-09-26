import mainimage from '../../image/1-default.jpg';



function Mainpage() {
    return (
        <main className="mainpage h-full">
            <div className="container px-4 mx-auto py-5">
                <div className="articles p-5 rounded-2xl">
                    <article className="flex flex-row gap-7">
                        <div className="basis-1/2">
                            <h2>Lorem ipsum dolor sit amet consectetur</h2>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Hic molestias reiciendis aperiam id
                                veritatis. Beatae dignissimos, molestias dolores temporibus eaque possimus corporis
                                necessitatibus repudiandae, alias placeat suscipit! Et, numquam cupiditate?
                            </p>
                            <input type="button" value="wiew" />
                        </div>
                        <div className="basis-1/2">
                            <img className="rounded-2xl" src={mainimage} alt="" />
                        </div>
                    </article>
                </div>
            </div>
        </main>
    )
}
export default Mainpage;