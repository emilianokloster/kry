import EndpointItem from "./EndpointItem";

const EndpointsList = ({ endpoints }) => {
	return (
    <div className="endpoints-container">
      {endpoints.map((endpoint) => (
        <EndpointItem key={endpoint.id} ep={endpoint} />
      ))}
    </div>
	);
};

export default EndpointsList;