<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>TS_Web_Regression</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>10</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <rerunImmediately>false</rerunImmediately>
   <testSuiteGuid>b1230b2f-41d1-4777-bb13-5c882b16d71e</testSuiteGuid>
   <testCaseLink>
      <guid>83f60427-7764-46d8-85dc-f09f2accb905</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Web/TC001_OpenCatalog</testCaseId>
      <usingDataBindingAtTestSuiteLevel>false</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>96613c65-1569-484b-9de6-afa5141915ea</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Web/TC002_RegisterNewAccount</testCaseId>
      <usingDataBindingAtTestSuiteLevel>false</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>da531544-cfc2-4b2a-83f9-ba978b604b9b</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Web/TC003_LoginValid</testCaseId>
      <usingDataBindingAtTestSuiteLevel>false</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>9a2bf524-aa69-4fbc-a0ba-106d8563b536</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Web/TC004_LoginDDT</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>f898865b-1d76-4218-91e6-c1e9e14f01bd</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/DT_LoginData</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>f898865b-1d76-4218-91e6-c1e9e14f01bd</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>username</value>
         <variableId>3601acb6-5111-4c8a-ba44-35ac4a7285f0</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f898865b-1d76-4218-91e6-c1e9e14f01bd</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>password</value>
         <variableId>342118e1-f4e3-4b6b-b8ee-bbf99672caa2</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>f898865b-1d76-4218-91e6-c1e9e14f01bd</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>expectedResult</value>
         <variableId>9452085e-4a1d-423b-937e-2025e393d9b3</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>8a24536d-99e2-4741-8ec8-a4af47944a05</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Web/TC005_LoginEmptyUsername</testCaseId>
      <usingDataBindingAtTestSuiteLevel>false</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>12787634-18e1-4e56-aa1e-b193a6bd7ed7</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Web/TC006_SelectProductCategory</testCaseId>
      <usingDataBindingAtTestSuiteLevel>false</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
</TestSuiteEntity>
