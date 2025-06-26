import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Input from './components/Input'
import Response from './components/Response'
import { fetchChatResponse } from './services/api'
function App() {
  const [response,setResponse] = useState(null)
  const [loading,setLoading] = useState(false)

  const handleQuestionSubmit = async (question) => {
    setLoading(true)
    setResponse(false)
    try {
      const apiResponse = await fetchChatResponse(question)
      setResponse(apiResponse)
    } catch (error) {
      alert("Failed to get the repsonse")
    }finally{
      setLoading(false)
    }  
  }

  return (
    <>
      <div className='App'>
        <header className='bg-blue-600 text-white text-center'>
          <h1 className='py-4'>My ChatBot</h1>
        </header>
      
        <Input onSubmit={handleQuestionSubmit}/>
        {loading && <h1>Loading...</h1>}
        <Response response={response}/>
      </div>
    </>
  )
}

export default App
