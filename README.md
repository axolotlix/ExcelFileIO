# ExcelIOHelpers
## Helper methods for excel input and output, ideal for use with selenium

Supports following filetypes with read and write methods:
  1. **.xls**
  2. **.xlsx**
  3. **.csv**
  
**Files should be in project directory / are written to project directory.**

```readTestInputsXLS``` & ```readTestInputsXLSX``` return data as a Map as intended use is for reading input data for use with selenium

```writeXLSFile``` & ```writeXLSXFile``` write data out respective formats given a filename, sheetname and data should be in ```List<List<String>>``` format

```readCSV``` method returns data as a ```List<List<String>>```, with params for the filename

```writeCSV``` method accepts a filename and data which should be in ```List<List<String>>``` format

Utilises java.nio.file input and output streams. Includes some junit tests to validate functionality
