import { useEffect, useState } from "react";
import { useParams, useHistory } from "react-router-dom";
import DisabledButton from "./DisabledButton";

const EndpointDetail = () => {
  const [endpoint, setEndpoint] = useState([]);
  const [isWorking, setIsWorking] = useState(false);
  const { id } = useParams();
  const redirect = useHistory();

  useEffect(() => {
    const fetchEndpoint = async () => {
      const response = await fetch(`http://localhost:8080/endpoints/${id}`);
      const data = await response.json();
      console.log(data);
      setEndpoint(data);
    };
    fetchEndpoint();
  }, [id]);
  
  const handleClick = () => {
    setIsWorking(true);
    fetch(`http://localhost:8080/endpoints/${endpoint.id}`, {
      method: 'DELETE'
    }).then(() => {
      setIsWorking(false);
      redirect.push("/endpoints");
    })
  };

  return (
    <div className="endpoint-detail">
      <h2>{endpoint.name}</h2>
      <p className="url">
        Endpoint url 
        <span className="decorated-span">
          {endpoint.url}
        </span>
      </p>

      <p>
        Last status 
        <span className="decorated-span">
          {endpoint.status}
        </span>
      </p>

      <div className="dates">
        <p>
          Added on 
          <span className="decorated-span">
            {endpoint.dateInsert}
          </span>
        </p>
        <p>
          Last updated
          <span className="decorated-span">
            {endpoint.dateLastUpdate}
          </span>
        </p>
      </div>

      <p className="comment">
        Comments <br/>
        <span className="decorated-span">
          {endpoint.comment}
        </span>
      </p>

      <div className="btns">
        {!isWorking && 
          <button className="black-btn" onClick={handleClick}>
            Delete
          </button>}
        {isWorking && <DisabledButton text="Saving changes..."/>}
      </div>
    </div>
  );
};

export default EndpointDetail;