import React from "react";
import { Link } from "react-router-dom";

const EndpointItem = ({ ep }) => {
  const url = `/endpoints/${ep.id}`;

  return (
    <>
      <div className="endpoint ep-name">
        {ep.name}
      </div>

      <div className="endpoint ep-status">
        {ep.status}
      </div>

      <div className="endpoint ep-details-link">
        <Link to={url}>
          Details
        </Link>
      </div>
    </>
  );
};

export default EndpointItem;
