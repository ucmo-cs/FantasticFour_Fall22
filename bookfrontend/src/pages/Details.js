import './Details.css';


function Details(){
    return(

        <>
            {/*Spaces to get under the header*/}
            <div>Header Hides</div>
            <div>Header Hides</div>
            <div>Header Hides</div>
            <div>Header Hides</div>

            <prog>
                {/*progbarfix is a fix for every prog bar bedsides the one on the purpose page, this is due to a mistake in the CSS in the purpose.css*/}
                <div className={"progbarfix"}>
                    {/*Start Navbar*/}
                    {/*each li is what you can consider to be a circle, with the label li following*/}
                    <div className="container">
                        <ul className="progress-bar">
                            {/*DO NOT KNOW HOW TO DEAL WITH GOING TO A FUTURE PAGE PAST THE ONE IN FRONT IF CUSTOMER HAS BEEN TO IT, MAY SCRAP FEATURE*/}
                            <li>
                                {/*First status circle*/}
                                <div className = "done"><a  href={"./"}><b>1</b></a></div>
                                <div><a  href={"./"}><b>Purpose</b></a></div>
                            </li>
                            <li>
                                {/*Second status circle*/}
                                <div className = "done"><a href = "./Location"><b>2</b></a></div>
                                <div><a href = "./Location"><b>Location</b></a></div>
                            </li>
                            <li>
                                {/*Third status circle*/}
                                <div className = "done"><a href = "./Time" ><b>3</b></a></div>
                                <div><a href = "./Time"><b>Time</b></a></div>
                            </li>
                            <li>
                                {/*Fourth status circle*/}
                                <div className={"current"}><a href = "./Details"><b>4</b></a></div>
                                <div><a href = "./Details"><b>Details</b></a></div>
                            </li>
                            <li>
                                {/*Fifth status circle*/}
                                <div><a href = "./Review"><b>5</b></a></div>
                                <div><a href = "./Review"><b>Review</b></a></div>
                            </li>
                        </ul>

                    </div>
                </div>
            </prog>

            {/*heading and subheading for the Details page*/}
            <h1>We just need a few more details about your visit!</h1>
            <p className={"subheading"}>Please provide all information asked in the boxes below</p>

            {/*using a grid to align the contents of Details, this promises even spacing and is just more useful*/}
            <div className={"grid"}>
                    {/*set up as LABEL - INPUT - LABEL - INPUT to line up correctly */}
                    <label className={"grid-item1"} htmlFor={"fname"}><b>First Name:</b></label>
                    <label className={"grid-item1"} htmlFor={"email"}><b>Email:</b></label>

                    <input type={"text"} name={"fname"} className={"grid-item"} required/>
                    <input type={"email"} name={"email"} placeholder={"example@email.com"} className={"grid-item"} required/>

                    <label className={"grid-item3"} htmlFor={"lname"}><b>Last Name:</b></label>
                    <label className={"grid-item3"} htmlFor={"phone"}><b>Phone Number:</b></label>

                    <input type={"text"} name={"lname"} className={"grid-item2"} required/>
                    <input type={"tel"} name={"phone"} placeholder={"(888)-555-3333"} pattern={"[0-9]{3}-[0-9]{3}-[0-9]{4}"} className={"grid-item2"} required/>
            </div>

            {/*continue button*/}
            <continue>
                <a href= "./Review"><button className={"buttonD"}>Continue</button></a>
            </continue>
        </>

    )
}
export default Details;