

export default function Response ({ response }) {
    if(!response) {
        return null;
    }

    const {candidates,usageMetadata} = response;

    return <div className="container my-8">
        <h1 className="text-2xl">Response</h1>
        {candidates.map ((candidate,index) => (
            <div className="mb-3" key={index}>
                <div className="card-body">
                    {/* <h5>Candidate {index + 1}</h5> */}
                    <p className="border border-gray-300 p-4 rounded">{candidate.content.parts[0].text}</p>

                    {/* <h6>Citatins:</h6> */}
                    <ul>
                        {candidates?.citationMetadata?.citationSources.map((source,idx) =>(
                            <li key={idx}>
                                <a href={source.url} target="_blank" rel="noopener noreferrar">
                                    {source.url}
                                </a> {" "} 
                                (Indexes: {source.startIndex} - {source.endIndex})
                            </li>
                        ))}
                    </ul>
                </div>
            </div>
        ))}

        {/* <h4>Usage Metadata</h4>
        <p>Prompt token: {usageMetadata.totalTokenCount}</p>
        <p>Candidates tokens: {usageMetadata.candidatesTokenCount}</p> */}
    </div>
    
    
}