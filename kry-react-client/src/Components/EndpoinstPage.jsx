import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import EndpointsList from "./EndpointsList";

const EndpointsPage = () => {
  const [endpoints, setEndpoints] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const interval = setInterval(() => {
      // Data will be fetched from the backend every two seconds

      const fetchEndpoints = async () => {
        const response = await fetch("http://localhost:8080/endpoints");
        const data = await response.json();
        setEndpoints(data);
        setIsLoading(false);
      };
      fetchEndpoints();

    }, 2000);

    return () => clearInterval(interval);
  }, []);

  return (
    <div className="endpoints-page">
      <Link to="/endpoints/add" className="black-btn">
        Add new
      </Link>
      {isLoading && <p style={{textAlign: "center", marginTop: "80px"}}>Loading...</p>}
      {!isLoading && endpoints[0] && <EndpointsList endpoints={endpoints}/>}
    </div>
  );
};

export default EndpointsPage;